package br.com.desafioinspiratech.util;

public class Cnpjutil {

    public static boolean isValid(String cnpj) {

        int soma = 0, dig;

        if (cnpj == null || cnpj.trim().isEmpty() || cnpj.trim().length() != 14
                || Long.valueOf(cnpj.trim()).equals(Long.valueOf("0"))) {
            return false;
        }

        String cnpj_calc = cnpj.substring(0, 12);
        char[] chr_cnpj = cnpj.toCharArray();

        /* Primeira parte */
        for (int i = 0; i < 4; i++) {
            if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
            }
        }

        for (int i = 0; i < 8; i++) {
            if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
            }
        }

        dig = 11 - (soma % 11);
        cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

        /* Segunda parte */
        soma = 0;
        for (int i = 0; i < 5; i++) {
            if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
            }
        }

        for (int i = 0; i < 8; i++) {
            if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
            }
        }

        dig = 11 - (soma % 11);
        cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
        return cnpj.equals(cnpj_calc.trim());
    }

    public static String unformat(String cnpj) {

        if (cnpj == null) {
            return "";
        }

        cnpj = cnpj.replaceAll("[\\.\\-_/ ]", "");

        if (cnpj.length() != 14) {
            return "";
        }
        return cnpj;

    }

    public static String format(String cnpj) {
        StringBuilder sb = new StringBuilder(cnpj).insert(2, ".").insert(6, ".").insert(10, "/").insert(15, "-");

        cnpj = sb.toString();

        return cnpj;
    }
}
