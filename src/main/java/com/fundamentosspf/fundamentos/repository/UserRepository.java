package com.fundamentosspf.fundamentos.repository;

import com.fundamentosspf.fundamentos.dto.UserDto;
import com.fundamentosspf.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    @Query("Select u from User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);
    @Query("Select u from User u WHERE u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);
    List<User> findByName(String name);

    //Using Named Parameters
    @Query("select u from User u WHERE u.name = :name or u.email = :email")
    Optional<User> findByNameOrEmail(@Param("name") String name,
                                     @Param("email") String email);
    @Query("SELECT new com.fundamentosspf.fundamentos.dto.UserDto(u.id, u.name, u.birthDate)" +
            " FROM User u " +
            " where u.birthDate=:parametroFecha " +
            " and u.email=:parametroEmail ")
    Optional<UserDto> getAllByBirthDayAndEmail(@Param("parametroFecha") LocalDate date, @Param("parametroEmail") String email);

    List<User> findAll();
}
