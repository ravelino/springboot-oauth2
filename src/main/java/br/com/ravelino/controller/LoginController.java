/**
 * 
 */
package br.com.ravelino.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ravelino.model.Login;

/**
 * @author ravelino
 *
 */

@RestController
@RequestMapping("/login")
public class LoginController {
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	//public ResponseEntity<Login> login(@RequestParam(value="user") String user) {
	public ResponseEntity<Login> login() {
		final Login l = new Login();
		l.setPassword("aaa");
		l.setLogin("ROGERIO");
		return new ResponseEntity(l, HttpStatus.OK);
	}

}
