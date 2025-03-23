package endpointsUtil;

public class Routes {

	public static String baseuri = "https://jsonplaceholder.typicode.com";
	public static String getSingleuser = "/posts/{id}";
	public static String getList = "/posts";
	public static String postRequest = "/posts";
	public static String putRequest = "/posts/{id}";
	public static String patchRequest = "/posts/{id}";
	public static String deleteRequest = "/posts/{id}";
	public static String filterRequest = "/comments?";
	public static String nestedRequest = "/posts/1/comments";
	public static String filterJsonPath = "/src/test/resources/Rest Assured Schemas/filterschema.json";
	public static String listJsonPath = "/src/test/resources/Rest Assured Schemas/listschema.json";
	public static String singleJsonPath= "/src/test/resources/Rest Assured Schemas/singleschema.json";

}


