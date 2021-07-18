package org.c2psi.gpointvente.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Operation {
    @Id
    String idOperation;
    String objetOperation;
    String descriptionOperation;
    String typeOperation;//Crédit (versement) ou debit (retrait)
}
