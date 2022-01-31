package com.franrodriguez.springboot.rest.empleos.app.auth;

public class JwtConfig {
	
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	
	/**
	 * Se utiliza para firmar el token
	 *
	 */
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpQIBAAKCAQEAvVKZUm9EH1Z2rMv6RdaGzdNV198OadPgiVe6gq2Doto0VCkh\r\n"
			+ "0+yLzh/GlccaUvEY2buO0CcbLrVq8yDfIaOfqZlaU4U4pqGKu6DMpN9iPGkNRW7P\r\n"
			+ "/Pv1GHHzHhZC+oG9UIDGpbp67quGiTFM8KCeHnXo9lkC1w8Ymy7qkTjNc0eypmxf\r\n"
			+ "erlOE6qnUjEHE0o/lU2CpN67DPWzBB0E9LD7Lcwle4ZCIxAAvY1oWVdwiN1QYQE9\r\n"
			+ "O76J74AW2xN464r2v0WluBYUSM0HU+GynEfQMUKCYXOTCUA1NGX6z4tKRppQ9vWd\r\n"
			+ "9fzaN1r6plnXBhTU+vyePaIFUK/AAX50f7NxfwIDAQABAoIBAC4khJPv5HWS2EfT\r\n"
			+ "S0NcPuzJdmGvzs6CQnaW+DFDYxL9BcYBZGpHe+eYHQmCRmsysfDXYr5e2aQvuUpa\r\n"
			+ "l6eWPqLSao5yqNUMCEkkrtv8SfAZVo+2q2CodBsqIqwRlu+BUYfeawwXgEDNc3Pa\r\n"
			+ "nTsEmqUn7cik9yk9V6zy6V7Nrl1LD/HtAqVs3XAVQbvGNZk9fB3lMZW+gBPSjDid\r\n"
			+ "P9G/FfjxSiQBAAYSVNotd0L7brsx57DMDBQWKah0zJ8fWWbstskVdW0aEoWusYKJ\r\n"
			+ "+NrvxJNr4Ro5UfmTdPIBskWpLHGRZ0Ya0bd5z6N6Fr80MzMiS559xPtZoXjUypIq\r\n"
			+ "mg/qKIkCgYEA3TmWkpAykQHPrsrQu92xPWrhkk4RfAb6oE/YlypzRw4GxiKv+ueX\r\n"
			+ "v5epcflhTegCfLzT6dpRF376FSgXLuxQ3KdDogWs2hMfIbhSCfuxCs43jztNxZpc\r\n"
			+ "fqp9zbmBkSR8WWT8FuYZdEE2KZ1bmhr0YGo65VSHSLyrzcQxPX8WnGMCgYEA2xU3\r\n"
			+ "TMHC6AHNGCZROO5rlQPzpe0uoR6nArDIKgszPhGEzFODh7lXKOxIv9wUblR940Gl\r\n"
			+ "oG+8Xkib2ao0AbXq2lNN1IlPSR5nkTCCQPdA02hTDA2q52YNOxMvL/9N8tnOM/fP\r\n"
			+ "H3VhDGntdJ5Vf66JX1EnuhQgksWx7e3J5s+Q+zUCgYEAk5jRghWc9yxbMQZ1/3Go\r\n"
			+ "yA5gU2mstrA9VOoQ2sJiyRxtnpIUEXWkxBpe3gEBT6Ykyq59QH/9LIz2M1ldJlxa\r\n"
			+ "ku0x7Y6VxaWOVsQQUELR2yC85t4tRFJ5tbTwXGqRLJJIOKhsnKaGgw7jIR6wt/+V\r\n"
			+ "3iHiC5G69OeURKPKKnp5TnsCgYEAmpeE9xe+1gH3XDQlmju7FGK+efY8shq0FNTz\r\n"
			+ "2Z8foIuyHpBLvukM1OauixvcGuJqFoOLQQO3cvxfZR+SJSbeOwMPZ4sgtGLNCAmn\r\n"
			+ "z/no94SlHVtDnpdHfMkTwhWwRk5lEAysTfGA8saIdYMIp9lcPDNDCi4LsiXoYREr\r\n"
			+ "KECNeIUCgYEAnThcYxh+Rtx8dNsiTAL7oYL09wccFaFRhnT8jHTiFy8mbv/fjV6P\r\n"
			+ "Gp8dBzKBTZvtkUT36N31+gCmyY820p0utFAxKkfaOL8Ho1a8qKg7I0Wlf0iaPbFJ\r\n"
			+ "3DrAXzm08UQ6O73tuTwUgpzY5mA0m4gR3DbmRrG8xPjWrJ0CAtVcvbc=\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	/**
	 * Verificar que el token sea valido
	 * 
	 */
	public static final String RSA_PUBLICA ="-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvVKZUm9EH1Z2rMv6RdaG\r\n"
			+ "zdNV198OadPgiVe6gq2Doto0VCkh0+yLzh/GlccaUvEY2buO0CcbLrVq8yDfIaOf\r\n"
			+ "qZlaU4U4pqGKu6DMpN9iPGkNRW7P/Pv1GHHzHhZC+oG9UIDGpbp67quGiTFM8KCe\r\n"
			+ "HnXo9lkC1w8Ymy7qkTjNc0eypmxferlOE6qnUjEHE0o/lU2CpN67DPWzBB0E9LD7\r\n"
			+ "Lcwle4ZCIxAAvY1oWVdwiN1QYQE9O76J74AW2xN464r2v0WluBYUSM0HU+GynEfQ\r\n"
			+ "MUKCYXOTCUA1NGX6z4tKRppQ9vWd9fzaN1r6plnXBhTU+vyePaIFUK/AAX50f7Nx\r\n"
			+ "fwIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";

}
