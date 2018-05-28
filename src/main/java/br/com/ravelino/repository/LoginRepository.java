/**
 * 
 */
package br.com.ravelino.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.ravelino.model.Login;

/**
 * @author ravelino
 *
 */
public interface LoginRepository extends PagingAndSortingRepository<Login, Long> {
	
	public Login findByLogin(String login);

}
