package com.seeds.neuroapp.service;
import com.seeds.neuroapp.model.Usuario;
import com.seeds.neuroapp.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    public void testSalvarUsuario() throws Exception {
        // Criação de um objeto Usuario para teste
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("John Doe");
        usuario.setEmail("johndoe@example.com");
        usuario.setSenha(123456);
        usuario.setTipoUsuario(1);

        // Configuração do comportamento simulado do UsuarioRepository
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        // Chama o método a ser testado
        Usuario resultado = usuarioService.salvarUsuario(usuario);

        // Verifica se o método save() do UsuarioRepository foi chamado
        verify(usuarioRepository, times(1)).save(usuario);

        // Verifica se o resultado retornado é igual ao objeto Usuario esperado
        assertEquals(usuario, resultado);
    }
}

