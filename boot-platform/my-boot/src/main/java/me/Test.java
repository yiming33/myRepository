package me;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Administrator on 2016/11/18.
 */

public class Test {

	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum E {
		A(1, "this is A"), B(2, "this is B");

		private Integer code;

		private String value;

		E(Integer code, String value) {
			this.code = code;
			this.value = value;
		}

		public Integer getCode() {
			return code;
		}

		public void setCode(Integer code) {
			this.code = code;
		}

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

	public static void main(String[] args) throws JsonProcessingException {
		System.out.println(new ObjectMapper().writeValueAsString(E.A));
	}
}
