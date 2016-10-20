package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Tools.HashPassword;

public class PasswordHashTest {

	@Test
	public void test_passwordHash() {
		String hash = HashPassword.Hash("dummy@gmail.com","password");
		System.out.println(hash);
		
		//assertTrue(hash == "feea72dc67a25559cc6044e845f298f6758b1007c7f28a4827d0efedb2902458") ;
		
		String hash2 = HashPassword.Hash("dummy@gmail.com","feea72dc67a25559cc6044e845f298f6758b1007c7f28a4827d0efedb2902458");
		System.out.println(hash2);
		
		//assertTrue(hash == "feea72dc67a25559cc6044e845f298f6758b1007c7f28a4827d0efedb2902458") ;
	}

}
