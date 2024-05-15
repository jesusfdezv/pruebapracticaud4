package org.iesvdm.reservamesa;

//import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReservaMesaTest {

    ReservaMesa reservaMesa = new ReservaMesa();

    @Test
    void failTest() {
        fail("TEST SIN IMPLEMENTAR");
    }

    // Busca la primera mesa vacia, como todas estan vacias la primera seria la
    // mesa 0.
    @Test
    void buscarPrimeraMesaVaciaTest() {

        int[] mesas = new int[10];
        reservaMesa.setTamanioMesa(4);

        reservaMesa.setMesas(mesas);


        assertThat(reservaMesa.buscarPrimeraMesaVacia()).isEqualTo(0);

    }

    // Busca la mesa para que quepan el numero de personas puesto
    // Si la primera mesa caben dos personas el test pasara
    @Test
    void buscarMesaParaCompartirTest(){


        int[] mesas = new int[5];
        reservaMesa.setMesas(mesas);
        reservaMesa.setTamanioMesa(4);

        reservaMesa.rellenarMesas();

        reservaMesa.imprimir();

        assertThat(reservaMesa.buscarMesaParaCompartir(2)).isEqualTo(0);

    }

    //Busca la mesa mas cercana a la dicha donde quepan las personas que queremos
    //Para ello tenemos que imprimir las mesas

    @Test
    void buscarMesaCompartirMasCercaDeTest(){
        int[] mesas = new int[10];
        reservaMesa.setMesas(mesas);
        reservaMesa.setTamanioMesa(4);

        reservaMesa.rellenarMesas();

        reservaMesa.imprimir();

        //Para que se cumpla este assert la mesa n2 tiene que estar ocupada y que la n1 quepan las personas
        assertThat(reservaMesa.buscarMesaCompartirMasCercaDe(1,2))
                .isEqualTo(0);
    }

    //Busca la mesa mas alejada de la puesta y donde quepan las personas
    @Test
    void buscarMesaCompartirMasAlejadaDeTest(){
        int[] mesas = new int[10];
        reservaMesa.setMesas(mesas);
        reservaMesa.setTamanioMesa(4);

        reservaMesa.rellenarMesas();

        reservaMesa.imprimir();

        // El assert se cumplira si en la mesa 9 caben personas
        // ya que es la mesa mas alejada
        assertThat(reservaMesa.buscarMesaCompartirMasAlejadaDe(1,2))
                .isEqualTo(9);
    }

    // Nos da la mesa donde empiezan a caber las personas segun las mesas que le pongamos
    @Test
    void buscarCompartirNMesasConsecutivasTest(){
        int[] mesas = new int[10];
        reservaMesa.setMesas(mesas);
        reservaMesa.setTamanioMesa(4);

        reservaMesa.rellenarMesas();

        reservaMesa.imprimir();

        //Ponemos 5 personas para que no quepan en una mesa, nos dira la primera mesa donde
        // pueden empezar a entrar las personas
        assertThat(reservaMesa.buscarCompartirNMesasConsecutivas(2,5)).
                isEqualTo(2);
    }

    // Colocamos una mesa para calcular de una manera facil los comensales
    @Test
    void comensalesTotalesTest(){
        int[] mesas = new int[1];
        reservaMesa.setMesas(mesas);
        reservaMesa.setTamanioMesa(4);

        reservaMesa.rellenarMesas();

        reservaMesa.imprimir();

        assertThat(reservaMesa.comensalesTotales()).isEqualTo(1);
    }

}

