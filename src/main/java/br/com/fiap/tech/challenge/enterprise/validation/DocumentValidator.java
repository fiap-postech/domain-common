package br.com.fiap.tech.challenge.enterprise.validation;

import br.com.fiap.tech.challenge.util.Strings;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;


public class DocumentValidator implements ConstraintValidator<DocumentCustomer, String> {
    //TODO: verificar se teremos Customer de PJ???
    public static final int ELEVEN = 11;
    public static final int FOURTEEN = 14;
    private static final String ANONYMOUS = "00000000000";

    private static final List<String> INVALID_CPFS = IntStream.range(ZERO.intValue(), TEN.intValue())
            .mapToObj(i -> StringUtils.repeat(String.valueOf(i), ELEVEN))
            .toList();
    private static final List<String> INVALID_CNPJS = IntStream.range(ZERO.intValue(), TEN.intValue())
            .mapToObj(i -> StringUtils.repeat(String.valueOf(i), FOURTEEN))
            .toList();

    private static final int[] CPF_WEIGHT = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] CNPJ_WEIGHT = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    public static final String REGEX_NOT_DIGIT = "\\D";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value)) {
            return false;
        }
        var formattedDocument = value.replaceAll(REGEX_NOT_DIGIT, Strings.EMPTY);
        if(formattedDocument.length() == ELEVEN) {
            return isValidCPF(formattedDocument);
        } else if(formattedDocument.length() == FOURTEEN) {
            return isValidCNPJ(formattedDocument);
        }

        return false;
    }

    public static boolean isValidCPF(String document) {
        if (ANONYMOUS.equals(document)) {
            return true;
        }
        if (Objects.isNull(document) || document.length() != ELEVEN || INVALID_CPFS.contains(document)) {
            return false;
        }
        var digit1 = calculate(document.substring(0,9), CPF_WEIGHT);
        var digit2 = calculate(document.substring(0,9) + digit1, CPF_WEIGHT);
        return document.equals(document.substring(0,9) + digit1 + digit2);
    }

    public static boolean isValidCNPJ(String document) {
        if (Objects.isNull(document) || document.length() != FOURTEEN || INVALID_CNPJS.contains(document)) {
            return false;
        }
        var digit1 = calculate(document.substring(0,12), CNPJ_WEIGHT);
        var digit2 = calculate(document.substring(0,12) + digit1, CNPJ_WEIGHT);
        return document.equals(document.substring(0,12) + digit1 + digit2);
    }

    private static int calculate(String str, int[] weight) {
        int sum = 0;
        for (int i = str.length()-1, digit; i >= 0; i-- ) {
            digit = Integer.parseInt(str.substring(i,i+1));
            sum += digit * weight[weight.length - str.length() + i];
        }
        sum = ELEVEN - sum % ELEVEN;
        return sum > 9 ? 0 : sum;
    }
}
