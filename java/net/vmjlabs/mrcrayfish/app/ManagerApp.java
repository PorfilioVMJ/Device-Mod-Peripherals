package net.vmjlabs.mrcrayfish.app;

import com.mrcrayfish.device.api.app.*;
import com.mrcrayfish.device.api.app.component.*;
import com.mrcrayfish.device.api.app.listener.ClickListener;
import com.mrcrayfish.device.api.app.listener.ItemClickListener;
import com.mrcrayfish.device.api.task.Callback;
import com.mrcrayfish.device.api.utils.BankUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public class ManagerApp extends Application{

    private String USERNAME = "";

    private Layout layoutLogin;
    private Label labelUsername;
    private TextField textFieldUsername;
    private Label labelPassword;
    private TextField textFieldPassword;
    private Button buttonLogin;

    private Layout layoutHome;
    private Label labelBalance;
    private Label currentUsername;

    private Layout layoutForSale;

    private Layout layoutOrders;

    //UNIVERSAL LAYOUT COMPONENTS

    private Button buttonOrders;
    private Button buttonForSale;
    private Button buttonHome;

    //LAYOUT EXTRAS
    //private ComboBox.List<String> saleList;
    private ItemList<String> saleList;
    private Label itemTitle;
    private Label itemDesc;
    private Button buyButton;
    private Label priceTag;
    private HashMap<String, String> itemMap = new HashMap<String, String>();
    private HashMap<String, Integer> itemPriceMap = new HashMap<String, Integer>();
    //END

    public ManagerApp(){
        //this.setDefaultWidth(100);
    }

    @Override
    public void init() {


        //MANAGE LAYOUTS
        layoutLogin = new Layout(100, 100);
        layoutForSale = new Layout(250, 150);
        layoutForSale.setTitle("Minezon - For Sale");
        layoutOrders = new Layout(250, 150);
        layoutOrders.setTitle("Minezon - Orders");

        labelUsername = new Label("Username",5,5);
        layoutLogin.addComponent(labelUsername);

        labelPassword = new Label("Password",5,40);
        layoutLogin.addComponent(labelPassword);

        textFieldUsername = new TextField(5,20, 90);
        layoutLogin.addComponent(textFieldUsername);

        textFieldPassword = new TextField(5, 55, 90);
        layoutLogin.addComponent(textFieldPassword);

        //BUTTON
        buttonLogin = new Button(5,75,90,20, "Login");
        buttonLogin.setClickListener(new ClickListener() {
            @Override
            public void onClick(int mouseX, int mouseY, int mouseButton) {
                if (mouseButton == 0) {
                    java.lang.System.out.println(ManagerApp.this.textFieldUsername.getText());
                    if (!ManagerApp.this.textFieldUsername.getText().equals("") || ManagerApp.this.textFieldUsername.getText() != null) {
                        USERNAME = ManagerApp.this.textFieldUsername.getText();
                        currentUsername.setText("Hello, " + USERNAME);
                        ManagerApp.this.setCurrentLayout(layoutHome);
                    }
                }
            }
        });
        layoutLogin.addComponent(buttonLogin);

        layoutHome = new Layout(250,150);
        layoutHome.setInitListener(() -> BankUtil.getBalance((nbtTagCompound, success) -> {
            if(success){
                labelBalance.setText("$" + nbtTagCompound.getInteger("balance"));
            }
        }));

        labelBalance = new Label("$0", 5, 5);
        labelBalance.setScale(2.0);
        currentUsername = new Label("Hello, ",5,25);

        //BUTTONS
        buttonHome = new Button(125,0,"Home");
        buttonHome.setClickListener(new ClickListener() {
            @Override
            public void onClick(int mouseX, int mouseY, int mouseButton) {
                if (ManagerApp.this.getCurrentLayout() != layoutHome) {
                    labelBalance.setScale(2.0);
                    ManagerApp.this.setCurrentLayout(layoutHome);
                }
            }
        });
        buttonForSale = new Button(155,0,"For Sale");
        buttonForSale.setClickListener(new ClickListener() {
            @Override
            public void onClick(int mouseX, int mouseY, int mouseButton) {
                if (ManagerApp.this.getCurrentLayout() != layoutForSale) {
                    labelBalance.setScale(1.0);
                    ManagerApp.this.setCurrentLayout(layoutForSale);
                }
            }
        });
        buttonOrders = new Button(205,0,"Orders");
        buttonOrders.setClickListener(new ClickListener() {
            @Override
            public void onClick(int mouseX, int mouseY, int mouseButton) {
                if (ManagerApp.this.getCurrentLayout() != layoutOrders) {
                    labelBalance.setScale(1.0);
                    ManagerApp.this.setCurrentLayout(layoutOrders);
                }
            }
        });

        layoutHome.addComponent(buttonHome);
        layoutHome.addComponent(buttonForSale);
        layoutHome.addComponent(buttonOrders);
        layoutForSale.addComponent(buttonHome);
        layoutForSale.addComponent(buttonForSale);
        layoutForSale.addComponent(buttonOrders);
        layoutOrders.addComponent(buttonHome);
        layoutOrders.addComponent(buttonForSale);
        layoutOrders.addComponent(buttonOrders);
        //END

        //RENDER HOME
        layoutHome.addComponent(labelBalance);
        layoutHome.setTitle("Minezon - Home");
        //END

        //RENDER FOR SALE

        saleList = new ItemList<>(5, 35, 70, 8);
        saleList.addItem("Test Item 1");
        itemMap.put("Test Item 1","This is the first item I'm selling!");
        itemPriceMap.put("Test Item 1",5);
        saleList.addItem("Test Item 2");
        itemMap.put("Test Item 2","This is the second item I'm selling!");
        itemPriceMap.put("Test Item 2",10);

        itemTitle = new Label(" ", 80, 35);
        itemDesc = new Label(" ", 80, 45);
        priceTag = new Label("FREE", 180, 110);

        saleList.setItemClickListener((s, index, mouseButton) -> {
            java.lang.System.out.println("Selected " + saleList.getSelectedItem());
            itemTitle.setText(saleList.getSelectedItem());
            itemDesc.setText(itemMap.get(saleList.getSelectedItem()));
            priceTag.setText("$"+itemPriceMap.get(saleList.getSelectedItem()));
        });

        buyButton = new Button(180, 130, 50, 20, "Buy");
        buyButton.setClickListener(new ClickListener() {
            @Override
            public void onClick(int mouseX, int mouseY, int mouseButton) {
                BankUtil.remove(itemPriceMap.get(saleList.getSelectedItem()), (nbtTagCompound, success) -> {

                });
            }
        });

        layoutForSale.addComponent(itemTitle);
        layoutForSale.addComponent(itemDesc);
        layoutForSale.addComponent(buyButton);
        layoutForSale.addComponent(priceTag);
        layoutForSale.addComponent(saleList);
        //END

        layoutForSale.addComponent(labelBalance);
        layoutOrders.addComponent(labelBalance);
        layoutHome.addComponent(currentUsername);

        layoutLogin.setTitle("Minezon - Login");
        this.setCurrentLayout(layoutLogin);
    }

    @Override
    public void load(NBTTagCompound tagCompound) {

    }

    @Override
    public void save(NBTTagCompound tagCompound) {

    }
}
