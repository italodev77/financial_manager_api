package com.fin.manager.PlanoDeContas.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_plano_de_contas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanoDeContas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    @Column(name = "emp_codigo")
    private Long codigoEmpresa;


}
