package org.example.exceptions;

public class CustomExceptionMain {

    /*
    Trebuie facuta validarea unui nr de telefon
    Reguli:
    -trebuie sa inceapa cu 0 sau cu 7
    -are 10 caractere daca incepe cu 0 sau 9 daca incepe cu 7
    -trebuie sa contina doar cifre
     */
    public static void main(String[] args) {

        try {
            valideazaNumarTelefon("67893030303");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());

            switch (e.getCodEroare()) {
                case 401:
                    break;
                case 402:
                    break;
                case 403:
                    break;

                default:
            }
        }

    }

    private static void valideazaNumarTelefon(String nrTelefon) throws ValidationException {
        if (nrTelefon == null || (!nrTelefon.startsWith("0")) || (!nrTelefon.startsWith("7"))) {
            throw new ValidationException("Numarul de telefon nu incepe cu 0 sau 7", 401);
        }

        if ((nrTelefon.startsWith("0") && nrTelefon.length() != 10)
                || (nrTelefon.startsWith("7") && nrTelefon.length() != 9)) {
            throw new ValidationException("Numarul de telefon nu are lungimea potrivita", 402);
        }

        //regex
        if (!nrTelefon.matches("[0,9]+")) {
            throw new ValidationException("numarul de telefon nu contine doar cifre", 403);
        }
    }
}
