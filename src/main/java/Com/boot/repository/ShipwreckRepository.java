package Com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.boot.model.Shipwreck;

public interface ShipwreckRepository  extends JpaRepository<Shipwreck, Long>{

}
