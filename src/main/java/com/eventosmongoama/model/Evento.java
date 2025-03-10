package com.eventosmongoama.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "eventos")
public class Evento {
    @Id
    private String id;
    @Indexed
    private String nombre;

    @Indexed
    private Date fecha;

    @Indexed
    private String hora;

    @Indexed
    private String lugar;

    @Indexed
    private List<String> artistas; // IDs de artistas

    @Indexed
    private double precioEntrada;
}
