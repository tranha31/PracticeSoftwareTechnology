
package TetThieuNhi;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Arrays;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.FileNotFoundException;
import java.util.Collections;

public class TongKetNam {
    private static Sheets sheetsService;
    private static String APPLICATION_NAME = "Google sheet";
    private static String SPREADSHEET_ID = "1jA46pN_oulD4aeQ7JYY4nzyS1UEDwQL3jfbNqFgnpG8";
    
    public TongKetNam(){
    
    }
    private static Credential authorize() throws IOException, GeneralSecurityException{
        InputStream in = TongKetNam.class.getResourceAsStream("/credentials (2).json");
        if(in == null){
            throw new FileNotFoundException("Resource not found:");
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JacksonFactory.getDefaultInstance(), new InputStreamReader(in)
        );
        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(),
                clientSecrets, scopes).setDataStoreFactory(
                        new FileDataStoreFactory(new java.io.File("token")))
                .setAccessType("offline").build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        return credential;
    }
    
    public static Sheets getSheetService() throws IOException, GeneralSecurityException {
        Credential credential = authorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), 
                JacksonFactory.getDefaultInstance(), credential).setApplicationName(APPLICATION_NAME).build();
    }
    public static void TruyCapSheet() throws IOException, GeneralSecurityException{
        sheetsService = getSheetService();
        String range = "Sheet1!A2:G";
        ValueRange response = sheetsService.spreadsheets().values().get(SPREADSHEET_ID, range).execute();
        List<List<Object>> values = response.getValues();
        if(values == null || values.isEmpty()){
            System.out.println("No Data Found");
        }
        else{
            for(List row : values){
                System.out.printf("%s\n",row.get(0));
            }
        }
    }
    
}
