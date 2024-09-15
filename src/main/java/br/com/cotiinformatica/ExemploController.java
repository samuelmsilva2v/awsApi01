package br.com.cotiinformatica;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alunos")
public class ExemploController {
	@GetMapping
	public List<AlunosDto> get() throws Exception {

		var host = "jdbc:postgresql://postgresql-coti.crws2maiaxdh.us-east-1.rds.amazonaws.com/AwsApi01";
		var user = "postgres";
		var pass = "Coti2024!";

		var connection = DriverManager.getConnection(host, user, pass);
		var statement = connection.prepareStatement("select * from alunos order by nome");
		var resultSet = statement.executeQuery();

		List<AlunosDto> alunos = new ArrayList<>();
		while (resultSet.next())
			alunos.add(new AlunosDto(resultSet.getInt(1), resultSet.getString(2)));

		connection.close();
		return alunos; // comentário teste
	}
}
