
public class Authentication 
{
	private static String password = "1234";
	public static boolean authentication(String correctPassword)
	{
		return (correctPassword.equals(password));
	}
}
