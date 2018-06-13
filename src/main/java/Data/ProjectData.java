package Data;

public class ProjectData {

    /*DATA FOR REGISTRATION.VALID DATA. NOT STATIC*/
    public static String ValidRegisterFirstName = "test+" + Math.random()*5;
    public static String ValidRegisterLastName = "test+" + Math.random()*5;
    public static String ValidRegisterEmail = "stanislav.leontjev+" + Math.random()*5 + "@bigdropinc.com";
    public static String ValidRegisterPassword = "123456789";
    public static String ValidRegisterConfirmPassword = "123456789";

    /*DATA FOR REGISTRATION.NOT VALID DATA. NOT STATIC*/
    public static String NotValidRegisterFirstName = "test+" + Math.random()*5;
    public static String NotValidRegisterLastName = "test+" +Math.random()*5;
    public static String NotValidRegisterEmail = "stanislav.leontjev+" + Math.random()*5 + "@bigdropinc";
    public static String NotValidRegisterPassword = "123456";
    public static String NotValidRegisterConfirmPassword = "123456789";

    /*DATA FOR LOGIN. REGISTERED USER. STATIC*/
    public static String LoginUserEmail = "stanislav.leontjev@bigdropinc.com";
    public static String LoginUserPassword = "987654321";

    /*DATA FOR LOGIN. NOT REGISTERED USER. STATIC*/
    public static String unregisteredLoginUserEmail = "stanislav123.leontjevasv@bigdropinc.com";
    public static String unregisteredLoginUserPassword = "98765432qwe1";

    /*DATA FOR GET A CATALOG FORM. STATIC*/
    public static String FullName = "Leon Test";
    public static String Address = "Address 111";
    public static String City = "Phoenix";
    public static String PostalZipCode = "85001";
    public static String Email = "stanislav.leontjev@bigdropinc.com";
    public static String PhoneNumber = "000 000-0000";

    /*DATA FOR SEARCH INAMT BY ID/NAME NOT STATIC*/
    public static String InmateFirstName = "Auto";
    public static String InmateLastName = "test";
    public static String InmateID = "Inmate12345";

    /*DATA FOR CREATE NEW INMATE. NOT STATIC */
    public static String NewInmateFirstName = "FirstName" + Math.random()*5;
    public static String NewInmateLastName = "LastName+" + Math.random()*5;
    public static String NewInmateID = "NewInmateId" + Math.random()*5;
    public static String NewHousingUnit = "Housing unit " + Math.random()*5;

    /*DATA FOR FOR FORGOT PASSWORD. STATIC*/
    public static String ForgotValidEmail = "stanislav.leontjev@bigdropinc.com";
    public static String ForgotNotExistEmail = "stanislav1234567.leontjev@bigdropinc.com";
    public static String ForgotNotValidEmail = "stanislav@test";
}
