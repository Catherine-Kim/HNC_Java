package sample;

import java.io.IOException;

public interface Outputter {
	void output(String message) throws IOException;	// file로 message를 출력하는 기능
}
