package org.example.training;

import org.example.listener.TestListener;
import org.example.training.model.User;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.fail;

@Listeners(TestListener.class)
public class TestCRUD {

    private List<User> users = new ArrayList<>();
    private SoftAssert softAssert = new SoftAssert();

    @DataProvider(name = "ExampleDataProvider" )
    public Object[][] getData(){
        return new Object[][]{
                {new User(1, "Иванов", "Иван", "Иванович")},
                {new User(2, "Петров", "Петр", "Петрович")},
                {new User(3, "", "Алексей", "Игоревич")},
                {new User(4, "TestLastName", "TestFirstName", "")},
                {new User(5, "Петрукевич", "", "Сергеевич")}
        };
    }

    /**
     * dataProvider - можно вызвать и по названию метода (пример: dataProvider = "getData")
     **/
    @Test(dataProvider = "ExampleDataProvider")
    public void post(User user) {
        checkObject(user, "POST");
        users.add(user);
    }

    @Test(dependsOnMethods = "post")
    public void put(){
        for (User user: users) {
            if(user.getId() == 2){
                user.setFirstName("");
            }
            if(user.getId() == 3){
                user.setLastName("Петрик");
            }
            if(user.getId() == 4){
                user.setMiddleName("TestMiddleName");
            }
            checkObject(user, "PUT");
        }
    }

    @Test(dependsOnMethods = {"post", "put"})
    public void get(){
        for (User user: users) {
            System.out.println(user);
        }
    }

    @Test(dependsOnMethods = "get")
    public void delete(){
        users.removeAll(users);
        users.add(new User(5, "Петрукевич", "", "Сергеевич"));
        softAssert.assertTrue(users.isEmpty(), "Список пользователей не пустой Метод: DELETE" );
    }

    private void checkObject(User user, String operation){
            softAssert.assertFalse(user.getLastName().isEmpty(), "Поле 'Фамилия' не должно быть пустым Метод: " + operation);
            softAssert.assertFalse(user.getFirstName().isEmpty(),"Поле 'Имя' не должно быть пустым Метод: " + operation);
            softAssert.assertFalse(user.getMiddleName().isEmpty(), "Поле 'Отчество' не должно быть пустым Метод: " + operation);
    }

    @Test(dependsOnMethods = "delete")
    public void checkListenerFail(){
        fail();
    }

    @AfterTest
    private void checkAsserts(){
        softAssert.assertAll();
    }

}
