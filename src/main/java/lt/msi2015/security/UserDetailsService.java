package lt.msi2015.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lt.msi2015.user.User;
import lt.msi2015.user.UserRepository;

@Service("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		System.out.println(email);

		User user = repo.findByEmail(email); // userDAO == null
			
		System.out.println("----------x-xx-x-x---------");// Causing NPE
		/*if (user == null)
			System.out.println("No such email");*/
		/*if(user.email == email) {
			System.out.println("Success");
		}
		else {
			System.out.println("No such email");
		}*/

//		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
		return null;
		/*return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), null);*/
	}

}
