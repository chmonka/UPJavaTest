import base.BaseTest;
import model.requestModal.JobRequest;
import model.requestModal.RequestLogin;
import model.requestModal.RequestUserAdd;
import org.junit.rules.TestName;
import org.testng.annotations.Test;

public class Tests extends BaseTest {


    @Test(testName = "ListUsers")
    public void reqresInTest() {
        REQRES_IN_STEPS.requestIn();
    }

    @Test(testName = "SingleUser")
    public void SingleUser() {
        REQRES_IN_STEPS.requestSingleUser();
    }

    @Test(testName = "SingleUserNotFound")
    public void SingleUserNotFound() {
        REQRES_IN_STEPS.NotFoundUser();
    }

    @Test(testName = "ListResourse")
    public void listResourseTest() {
        REQRES_IN_STEPS.listResourse();
    }

    @Test(testName = "SingleResourse")
    public void SingleResourseTest() {
        REQRES_IN_STEPS.singleResourse();
    }

    @Test(testName = "SingleResourseNotFound")
    public void SingleResourseNotFoundTest() {
        REQRES_IN_STEPS.singleResourseNotFound();
    }

    @Test(testName = "Create")
    public void postCreateTest() {
        JobRequest jober = new JobRequest("morpheus", "leader");
        REQRES_IN_STEPS.postCreate(jober);
    }

    @Test(testName = "Update")
    public void putCreateTest(){
        JobRequest lider = new JobRequest("morpheus", "zion resident");
        REQRES_IN_STEPS.putUpdate(lider);
    }

    @Test(testName = "UpdatePatch")
    public void patchCreateTest() {
        JobRequest lider = new JobRequest("morpheus", "zion rezident");
        REQRES_IN_STEPS.patchUpdate(lider);
    }

    @Test(testName = "Delete")
    public void deleteTest() {
        REQRES_IN_STEPS.deleteApi();
    }

    @Test(testName = "RegisterSucceful")
    public void registerTest() {
        RequestUserAdd userLogin = new RequestUserAdd("eve.holt@reqres.in", "pistol");
        REQRES_IN_STEPS.RegisterCreate(userLogin);
    }

    @Test(testName = "RegisterUnsucceful")
    public void registerUnTest() {
        REQRES_IN_STEPS.RegisterUNCreate();
    }

    @Test(testName = "LoginSucceful")
    public void loginTest() {
        RequestLogin User = new RequestLogin("eve.holt@reqres.in", "cityslicka");
        REQRES_IN_STEPS.loginUser(User);
    }

    @Test(testName = "LoginUnsucceful")
    public void loginUnTest() {
        REQRES_IN_STEPS.loginUnUser();
    }

    @Test(testName = "DelayedResponse")
    public void DelayTest() {
        REQRES_IN_STEPS.Delay();
    }
}
