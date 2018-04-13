package com.square.rbc.apppropapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.square.rbc.apppropapi.model.RbcApp;

/**
 * 
 * @author equadrado
 *
 */
public interface RbcAppRepository extends JpaRepository<RbcApp, Long> {

	/**
	 * 
	 * @param parId
	 * @return An Application with all its versions ordered by modification date in descendent
	 * 			order
	 */
	@Query
	("SELECT RA "
	            + "FROM RbcApp AS RA "
	            + "JOIN RA.appVersions AS AV "
	            + "WHERE RA.id = :parId "
	            + "ORDER BY AV.lastmodification")
	RbcApp findRbcAppByIdOrdered(@Param("parId") Long parId);
	
}
