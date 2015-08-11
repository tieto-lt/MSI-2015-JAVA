package lt.msi2015.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lt.msi2015.user.User;
import lt.msi2015.user.UserRepository;

@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(email);
		
//		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//	    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//	    org.springframework.security.core.userdetails.User userDetails = 
//	    		new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
//	            authorities);
//	    return userDetails;
	   
		
		
		return new org.springframework.security.core.userdetails.User(email,
                user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
				
		/*if (user == null)
			System.out.println("No such email");*/
		/*if(user.email == email) {
			System.out.println("Success");
		}
		else {
			System.out.println("No such email");
		}*/

//		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
		//return null;
		/*return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), null);*/
	}

}
