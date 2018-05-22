package litecart.util;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Dataproviders {
    @DataProvider(name =  "createUser")
    public Object[][] createData() {
        return new Object[][] {
                {"number1@user.com", "Password"},
                {"number2@user.com", "Password"},
                {"number3@user.com", "Password"},
                {"number4@user.com", "Password"},
                {"number5@user.com", "Password"},
        };
    }


    @DataProvider(name = "loginData")
    public Iterator<Object[]> passwordFileCheckedData() throws IOException{
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/test_data/login.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(";");
            list.add(new Object[]{split[0], split[1]});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
