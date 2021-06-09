import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../model/Usuario';
import { UsuarioLogin } from '../model/UsuarioLogin';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuarioLogin: UsuarioLogin = new UsuarioLogin()
  usuario: Usuario = new Usuario
  confirmarSenha: string

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
    window.scroll(0,0) 
  }

  login(){
    this.authService.login(this.usuarioLogin).subscribe((resp: UsuarioLogin)=>{
      this.usuarioLogin = resp
      this.router.navigate(['/feed'])
    })
  }

  confirmSenha(event: any){
    this.confirmarSenha = event.target.value
  }

  cadastrar(){

    if(this.usuario.senha != this.confirmarSenha){
      alert('As senhas estão incorretas!')
    } else {
      this.authService.cadastrar(this.usuario).subscribe((resp: Usuario)=>{
        this.usuario = resp
        alert('Usuario cadastrado com sucesso!')
        this.usuario = new Usuario
      })
    }
  }

}
