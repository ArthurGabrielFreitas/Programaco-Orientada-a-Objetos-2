package classe_abstrata;

public class App {
    public static void main(String[] args) {
        final GeometriaPlana geometriaPlana = new GeometriaPlana();

        geometriaPlana.mudaParaTriangulo();
        System.out.println(geometriaPlana.exibe());

        geometriaPlana.mudaParaCirculo();
        System.out.println(geometriaPlana.exibe());

        geometriaPlana.mudaParaQuadrado();
        System.out.println(geometriaPlana.exibe());
    }
}
