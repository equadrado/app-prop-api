package com.square.rbc.apppropapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.square.rbc.apppropapi.model.AppVersion;
import com.square.rbc.apppropapi.model.RbcApp;

/**
 * 
 * @author equadrado
 *
 */
public interface AppVersionRepository extends JpaRepository<AppVersion, Long> {

	/**
	 * 
	 * @param version
	 * @param rbcApp (RbcApp Object)
	 * @return An Application configuration for that Application (rbcApp) and version (version)
	 */
	AppVersion findByVersionAndRbcApp(String version, RbcApp rbcApp);

	/**
	 * 
	 * @param version
	 * @param parId
	 * @return An Application configuration for that Application ID (parId) and version (version)
	 */
	@Query
	("SELECT AV "
	            + "FROM RbcApp AS RA "
	            + "JOIN RA.appVersions AS AV "
	            + "WHERE RA.id = :parId AND AV.version = :version ")
	AppVersion findByVersionAndRbcAppId(@Param("version") String version, @Param("parId") Long parId );

}
