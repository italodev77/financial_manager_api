package com.fin.manager.Contas.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_contas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_cliente")
    private Long codigoCliente;

    @Column(name = "emp_codigo")
    private Long codigoEmpresa;


    @Column(name = "codigo_fornecedor")
    private Long codigoFornecedor;

    @Column(name = "tipo_da_conta", length = 50)
    private String tipoDaConta;

    @Column(name = "numero_do_documento", length = 50)
    private String numeroDoDocumento;

    @Column(name = "numero_da_parcela")
    private Integer numeroDaParcela;

    @Column(name = "vencimento")
    private LocalDate vencimento;

    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    @Column(name = "valor_documento", precision = 15, scale = 2)
    private BigDecimal valorDocumento;

    @Column(name = "juros", precision = 10, scale = 2)
    private BigDecimal juros;

    @Column(name = "multa", precision = 10, scale = 2)
    private BigDecimal multa;

    @Column(name = "especie_da_conta", length = 50)
    private String especieDaConta;

    @Column(name = "status_conta", length = 50)
    private String statusConta;

    @Column(name = "plano_de_contas", length = 100)
    private String planoDeContas;
}
