package org.lessons.java.versante_nord.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank (message = "il campo titolo è obbligatorio")
    private String titolo;

    private String sottotitolo;

    @NotBlank (message = "il campo autore è obbligatorio")
    private String autore;

    @Lob
    private String descrizione;

    @NotBlank(message = "il campo ISBN è obbligatorio")
    @Size(min = 10, max = 13, message = "il campo ISBN deve essere tra 10 e 13 caratteri")
    private String isbn;

    private LocalDate dataPubblicazione;

    @NotNull(message = "il campo prezzo è obbligatorio")
    @Min(value = 0, message = "il campo prezzo deve essere maggiore di 0")
    private BigDecimal prezzo;

    private String immagine;

    @NotNull(message = "il campo pagine è obbligatorio")
    @Min(value = 1, message = "il campo pagine deve essere maggiore di 0")
    private Integer pagine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    @JsonBackReference
    @NotNull(message = "il campo regione è obbligatorio")
    private Region region;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "book_category",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getSottotitolo() {
        return this.sottotitolo;
    }

    public void setSottotitolo(String sottotitolo) {
        this.sottotitolo = sottotitolo;
    }

    public String getAutore() {
        return this.autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public BigDecimal getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String getImmagine() {
        return this.immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }


    public LocalDate getDataPubblicazione() {
        return this.dataPubblicazione;
    }

    public void setDataPubblicazione(LocalDate dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }


    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPagine() {
        return this.pagine;
    }

    public void setPagine(Integer pagine) {
        this.pagine = pagine;
    }


    public Region getRegion() {
        return this.region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }


    public List<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }



    @Override
    public String toString() {
        return "Book [id=" + id + ", titolo=" + titolo + ", sottotitolo=" + sottotitolo + ", autore=" + autore
                + ", descrizione=" + descrizione + ", isbn=" + isbn + ", dataPubblicazione=" + dataPubblicazione
                + ", prezzo=" + prezzo + ", immagine=" + immagine + ", pagine=" + pagine + "]";
    }

}
