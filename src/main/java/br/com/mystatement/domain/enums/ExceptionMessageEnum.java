package br.com.mystatement.domain.enums;

import lombok.Getter;

@Getter
public enum ExceptionMessageEnum {

    BUSINESS_ERROR("error.payment.business"),
    CLIENT_ERROR("error.generic.client-error"),
    INVALID_DIGITAL_LINE("error.generic.invalid-digital-line"),
    ERROR_FORMAT_DOCUMENT("error.payment.format-document"),
    ERROR_PDF_FILE_GENERATION("error.payment.pdf-file-generation"),
    JSON_PARSER_ERROR("error.generic.json-parser-error"),
    INVALID_BASE64_CHARACTER("error.generic.invalid-base64-character"),
    INVALID_CPF_OR_CNPJ("error.generic.invalid-cpf-or-cnpj"),
    ERROR_VALIDATE_DATE("error.validate.date"),
    WORKBOOK_IO_EXCEPTION("error.workbook-io-exception"),
    WORKBOOK_DATE_PARSE_ERROR("error.workbook-date-parse-error"),
    BANK_STATEMENT_EXPORT_NO_FILE_TYPE("error.bank-statement.export-statement.no-file-type");

    private final String messageKey;

    ExceptionMessageEnum(String messageKey) {
        this.messageKey = messageKey;
    }

    @Override
    public String toString() {
        return messageKey;
    }
}