package com.workintech.sqlintro.repository;

import com.workintech.sqlintro.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

    // Ogrenci tablosundaki tum kayitlari listeleyin.
    String QUESTION_1 = "select * from ogrenci;";
    @Query(value = QUESTION_1, nativeQuery = true)
    List<Ogrenci> findAll();

    // Ogrenci tablosundaki kiz ogrencileri listeleyin.
    String QUESTION_2 = "select * from ogrenci where cinsiyet = 'K';";
    @Query(value = QUESTION_2, nativeQuery = true)
    List<Ogrenci> findGirls();

    // Ogrenci tablosunda kaydi bulunan siniflarin adini her sinif bir kez goruntulenecek sekilde listeleyiniz.
    String QUESTION_3 = "select distinct sinif from ogrenci;";
    @Query(value = QUESTION_3, nativeQuery = true)
    List<String> findAllClasses();

    // Ogrenci tablosunda, 10A sinifinda olan kiz ogrencileri listeleyiniz.
    String QUESTION_4 = "select * from ogrenci where sinif = '10A' and cinsiyet = 'K';";
    @Query(value = QUESTION_4, nativeQuery = true)
    List<Ogrenci> find10AGirls();

    // Ogrenci numarasi 5 ile 10 arasinda olan kiz ogrencileri listeleyiniz.
    String QUESTION_5 = "select * from ogrenci where cinsiyet = 'K' and ogrno between 6 and 10;";
    @Query(value = QUESTION_5, nativeQuery = true)
    List<Ogrenci> findGirlsWithOgrno();

    // Ogrencileri adina gore siralayiniz (alfabetik)
    String QUESTION_6 = "select * from ogrenci order by ad asc";
    @Query(value = QUESTION_6, nativeQuery = true)
    List<Ogrenci> findStudentsAlphabetically();

    // 10A sinifindaki ogrencileri okul numarasina gore azalan olarak siralayiniz.
    String QUESTION_7 = "select * from ogrenci where sinif = '10A' order by ogrno desc;";
    @Query(value = QUESTION_7, nativeQuery = true)
    List<Ogrenci> find10AStudentsByOgrNo();

    // Ogrenciler tablosundaki en genc ogrenciyi listeleyiniz.
    String QUESTION_8 = "select * from ogrenci order by dtarih desc limit 1;";
    @Query(value = QUESTION_8, nativeQuery = true)
    Ogrenci findYoungestStudent();

    // Ogrenciler tablosundaki en yasli ogrenciyi listeleyiniz.
    String QUESTION_9 = "select * from ogrenci order by dtarih asc limit 1;";
    @Query(value = QUESTION_9, nativeQuery = true)
    Ogrenci findElderStudent();

    // Ikinci harfi E olan ogrencileri listeleyiniz.
    String QUESTION_10 = "select * from ogrenci where ad like '_e%';";
    @Query(value = QUESTION_10, nativeQuery = true)
    List<Ogrenci> findStudentsSecondLetterOfN();
}
