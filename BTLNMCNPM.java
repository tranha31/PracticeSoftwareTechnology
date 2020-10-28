/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btlnmcnpm;

import javafx.geometry.Insets;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.stage.*;
import javafx.util.Pair;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.application.*;
import java.lang.Override;
import java.util.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BTLNMCNPM extends Application {
    public static ArrayList<Pair<String, String>> tk = new ArrayList<Pair<String, String>>();
    public BTLNMCNPM(){
    }
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        //primaryStage.setTitle("QUẢN LÝ PHẦN QUÀ");
        Button button2 = new Button("Register");
        button2.setOnAction(e->{
            Dialog<Pair<String, String>> dialog1 = new Dialog<>();
            dialog1.setTitle("Register Dialog");
            dialog1.setHeaderText("Register");
            ButtonType loginButtonType1 = new ButtonType("Register", ButtonBar.ButtonData.OK_DONE);
            dialog1.getDialogPane().getButtonTypes().addAll(loginButtonType1, ButtonType.CANCEL);
            GridPane grid1 = new GridPane();
            grid1.setHgap(10);            //Tạo 10 cột, 10 hàng
            grid1.setVgap(10);		
            TextField userName1 = new TextField();
            userName1.setPromptText("Username");
            PasswordField password1 = new PasswordField();
            password1.setPromptText("Password");
            grid1.add(new Label("Username"),0,0);
            grid1.add(userName1,1,0);
            grid1.add(new Label("Password"),0,1);
            grid1.add(password1,1,1);
            Node loginButton = dialog1.getDialogPane().lookupButton(loginButtonType1);
            loginButton.setDisable(true);
            userName1.textProperty().addListener((observable, oldValue, newValue)->{  //Lựa chọn cho userName có thể quan sát được từ nhập vào
                loginButton.setDisable(newValue.trim().isEmpty());     //Nút login chỉ hiển thị khi có kí tự khác trống nhập vào
            });
            dialog1.getDialogPane().setContent(grid1);
            dialog1.setResultConverter(dialogButton->{
                if(dialogButton == loginButtonType1) {
                    Pair<String, String> p = new Pair<>(userName1.getText(), password1.getText());
                    tk.add(p);
                    return p;
		}
                return null;
            });
            Optional<Pair<String, String>> result = dialog1.showAndWait();
            try {
                File in = new File("src/btlnmcnpm/Taikhoan.txt");
                try {
                    String a = result.get().getKey();
                    String b = result.get().getValue();
                    FileWriter fw = new FileWriter(in);
                    fw.write(a+"\n");
                    fw.write(b+"\n");
                    fw.close();
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(BTLNMCNPM.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(BTLNMCNPM.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button button1 = new Button("Login");
        button1.setOnAction(event ->{
            Dialog<Pair<String, String>> dialog = new Dialog<>();
            dialog.setTitle("Login Dialog");
            dialog.setHeaderText("Sign up");
            ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
            GridPane grid = new GridPane();
            grid.setHgap(10);            //Tạo 10 cột, 10 hàng
            grid.setVgap(10);		
            TextField userName = new TextField();
            userName.setPromptText("Username");
            PasswordField password = new PasswordField();
            password.setPromptText("Password");
            grid.add(new Label("Username"),0,0);
            grid.add(userName,1,0);
            grid.add(new Label("Password"),0,1);
            grid.add(password,1,1);
            		
            //Nhận thông tin nhập vào các ô
            Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
            loginButton.setDisable(true);
            userName.textProperty().addListener((observable, oldValue, newValue)->{  //Lựa chọn cho userName có thể quan sát được từ nhập vào
                loginButton.setDisable(newValue.trim().isEmpty());     //Nút login chỉ hiển thị khi có kí tự khác trống nhập vào
            });
            dialog.getDialogPane().setContent(grid);
            dialog.setResultConverter(dialogButton->{
                if(dialogButton==loginButtonType) {
                    return new Pair<>(userName.getText(), password.getText());
		}
                return null;
            });
			
            Optional<Pair<String, String>> result = dialog.showAndWait();
            result.ifPresent(userNamepassword->{
            //Kiểm tra xem user và password đúng hay sai
            //if(!tk.isEmpty()){
            int dem = 0;
            for(Pair<String, String> v : tk){
                if(userNamepassword.getKey().equals(v.getKey()) && (userNamepassword.getValue().equals(v.getValue()))){
                    dem++;
                    Button b1 = new Button(" Cập nhật "+"\n"+" dữ liệu ");
                    b1.setStyle("-fx-font: 18 arial; -fx-base: #FFD700");
                    Button b2 = new Button(" Tổng kết "+"\n"+" năm ");
                    b2.setStyle("-fx-font: 18 arial; -fx-base: #FFD700");
                    Button b3 = new Button(" Các dịp "+"\n"+" trong năm ");
                    b3.setStyle("-fx-font: 18 arial; -fx-base: #FFD700");
                    Button b4 = new Button("Quay lại");
                    b4.setStyle("-fx-font: 18 arial; -fx-base: #FFD700");
                    b1.setOnAction(e->{
                        
                    });
                    b2.setOnAction(e->{
                        
                    });
                    b3.setOnAction(e->{
                        
                    });
                    b4.setOnAction(e->{
                        VBox V1 = new VBox(3);
                        Image image1, image2, image3;
                        Class<?> clazz = this.getClass();
                        InputStream input1 = clazz.getResourceAsStream("/btlnmcnpm/logobk.jpg");
                        image1 = new Image(input1,200,200,true,true);
                        ImageView imageView1 = new ImageView(image1);
                        InputStream input2 = clazz.getResourceAsStream("/btlnmcnpm/hopqua.jpg");
                        image2 = new Image(input2,500,500,true,true);
                        ImageView imageView2 = new ImageView(image2);
                        InputStream input3 = clazz.getResourceAsStream("/btlnmcnpm/hcn.jpg");
                        image3 = new Image(input3,180,180,true,true);
                        ImageView imageView3 = new ImageView(image3);
        
                        V1.setMargin(button1, new Insets(55, 50, 10, 65));
                        V1.setMargin(button2, new Insets(10, 50, 0, 57));
                        V1.setPadding(new Insets(30));
                        Label lb = new Label("QUẢN LÝ PHẦN QUÀ");
                        lb.setFont(new Font("Aria", 20));
                        lb.setTextFill(Color.web("#FF2400"));
                        V1.getChildren().addAll(lb, button1, button2);
                        StackPane sp = new StackPane();
                        sp.getChildren().addAll(imageView3, V1);
                        HBox H = new HBox(3);
                        H.setMargin(imageView1, new Insets(50,0, 0, 50));
                        H.setMargin(sp, new Insets(0,0, 0, 30));
                        H.getChildren().addAll(imageView1, sp);
                        StackPane sk = new StackPane();
                        sk.getChildren().addAll(imageView2, H);
                        Scene S = new Scene(sk, 520, 320);
                        primaryStage.setScene(S);
                        primaryStage.show();
                    });
                    Image image, images;
                    Class<?> clazz = this.getClass();
                    InputStream input = clazz.getResourceAsStream("/btlnmcnpm/hinh2.png");
                    image = new Image(input,300,300,true,true);
                    ImageView imageView = new ImageView(image);
                    InputStream inputs = clazz.getResourceAsStream("/btlnmcnpm/background.jpg");
                    images = new Image(inputs,750,750,true,true);
                    ImageView imageViews = new ImageView(images);
                    
                    HBox v1 = new HBox(3);
                    v1.setMargin(b1, new Insets(10, 50, 0, 55));
                    v1.setMargin(b2, new Insets(10, 50, 0, 40));
                    v1.setMargin(b3, new Insets(10, 50, 0, 40));
                    v1.setPadding(new Insets(30));
                    v1.getChildren().addAll(b1, b2, b3);
                    VBox h = new VBox(3);
                    h.setMargin(imageView, new Insets(50,0, 0, 200));
                    h.setMargin(v1, new Insets(0,0, 0, 10));
                    h.setMargin(b4, new Insets(0,0, 0, 304));
                    h.getChildren().addAll(imageView, v1, b4);
                    StackPane sp1 = new StackPane();
                    sp1.getChildren().addAll(imageViews, h);
                    Scene s1 = new Scene(sp1, 700, 500);
                    primaryStage.setScene(s1);
                    primaryStage.show();
                    break;
                }
            }
            if(dem == 0){
                //Hiện thông báo lỗi do nhập sai user hoặc password
                    Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Login Failed");
                    alert1.setHeaderText("Check username or password");
                    alert1.setContentText("Incorrect");
                    alert1.show();
                }
            });
        });
        
        VBox V1 = new VBox(3);
        Image image1, image2, image3;
        Class<?> clazz = this.getClass();
        InputStream input1 = clazz.getResourceAsStream("/btlnmcnpm/logobk.jpg");
        image1 = new Image(input1,200,200,true,true);
        ImageView imageView1 = new ImageView(image1);
        InputStream input2 = clazz.getResourceAsStream("/btlnmcnpm/hopqua.jpg");
        image2 = new Image(input2,550,550,true,true);
        ImageView imageView2 = new ImageView(image2);
        InputStream input3 = clazz.getResourceAsStream("/btlnmcnpm/hcn.jpg");
        image3 = new Image(input3,180,180,true,true);
        ImageView imageView3 = new ImageView(image3);
        
        V1.setMargin(button1, new Insets(55, 50, 10, 65));
        V1.setMargin(button2, new Insets(10, 50, 0, 57));
        V1.setPadding(new Insets(30));
        Label lb = new Label("QUẢN LÝ PHẦN QUÀ");
        lb.setFont(new Font("Aria", 20));
        lb.setTextFill(Color.web("#FF2400"));
        V1.getChildren().addAll(lb, button1, button2);
        StackPane sp = new StackPane();
        sp.getChildren().addAll(imageView3, V1);
        HBox H = new HBox(3);
        H.setMargin(imageView1, new Insets(50,0, 0, 50));
        H.setMargin(sp, new Insets(0,0, 0, 30));
        H.getChildren().addAll(imageView1, sp);
        StackPane sk = new StackPane();
        sk.getChildren().addAll(imageView2, H);
        Scene S = new Scene(sk, 520, 320);
        primaryStage.setScene(S);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        try{
            InputStream in = new FileInputStream("src/btlnmcnpm/Taikhoan.txt");
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            String line = br.readLine();
            while(line != null){
                String TK = line;
                line = br.readLine();
                String MK = line;
                tk.add(new Pair<>(TK,MK));
                line = br.readLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
	launch(args);
    }
}
