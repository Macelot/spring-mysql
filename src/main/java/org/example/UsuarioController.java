package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository customerRepository;

    @PostMapping("/add")
    public String addCustomer(@RequestParam String nome, @RequestParam String email, @RequestParam Float salario, @RequestParam String senha, @RequestParam Character sexo) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setDataCadastro(new Date());
        usuario.setSalario(salario);
        usuario.setSexo(sexo);
        customerRepository.save(usuario);
        return "Novo usuário adicionado";
    }


    @GetMapping("/list")
    public Iterable<Usuario> getUsuarios() {
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Usuario findUsuarioById(@PathVariable Integer id) {
        return customerRepository.findUsuarioById(id);
    }
}
