package Tools;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



	@SuppressWarnings("unused")
	public class DBUtil {
		private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BusinessProcessApplication");
		public static EntityManagerFactory getEmFactory(){
			return emf;
		}
		
		public static String getGravatarURL(String email, Integer size) {
			String url = "http://www.gravatar.com/avatar/" + MD5Util.md5Hex(email) + "?s=" + size.toString();
			return url;
		}
	}



