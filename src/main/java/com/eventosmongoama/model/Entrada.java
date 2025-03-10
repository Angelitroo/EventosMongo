package com.eventosmongoama.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "entradas")
public class Entrada {
    @Id
    private String id;

    @Indexed
    private String eventoId;

    @Indexed
    private String comprador;

    @Indexed
    private boolean anulada;
}
