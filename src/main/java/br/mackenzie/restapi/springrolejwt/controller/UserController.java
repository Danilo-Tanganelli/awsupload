package br.mackenzie.restapi.springrolejwt.controller;

// import com.akhianand.springrolejwt.config.TokenProvider;
// import com.akhianand.springrolejwt.model.AuthToken;
// import com.akhianand.springrolejwt.model.LoginUser;
// import com.akhianand.springrolejwt.model.UserJwt;
// import com.akhianand.springrolejwt.model.UserDto;
// import com.akhianand.springrolejwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import br.mackenzie.restapi.springrolejwt.config.TokenProvider;
import br.mackenzie.restapi.springrolejwt.model.AuthToken;
import br.mackenzie.restapi.springrolejwt.model.LoginUser;
import br.mackenzie.restapi.springrolejwt.model.UserJwt;
import br.mackenzie.restapi.springrolejwt.model.UserDto;
import br.mackenzie.restapi.springrolejwt.service.UserService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public UserJwt saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }



    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/adminping", method = RequestMethod.GET)
    public String adminPing(){
        return "Only Admins Can Read This";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/userping", method = RequestMethod.GET)
    public String userPing(){
        return "Any UserJwt Can Read This";
    }

}
