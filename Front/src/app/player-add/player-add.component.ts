import {Component, OnInit} from '@angular/core';
import {ApiConnectionService} from '../service/api-connection.service';
import {FormBuilder} from '@angular/forms';
import {Player} from '../class/player';

@Component({
  selector: 'app-player-add',
  templateUrl: './player-add.component.html',
  styleUrls: ['./player-add.component.css']
})
export class PlayerAddComponent implements OnInit {

  playerForm;
  txtValue: string = null;

  constructor(
    private formBuilder: FormBuilder,
    private connectionService: ApiConnectionService
  ) {
    this.playerForm = this.formBuilder.group({
      username: ''
    });
  }

  onSubmit(player) {
    console.log('validation des données new player');
    this.txtValue = player.username;
    if (this.txtValue === null) {
      window.alert('Tu as oublié d\'indiquer ton pseudo de joueur !');
    } else {
      this.connectionService.addPlayer(player).subscribe(
        savePlayer => {
          console.log(savePlayer);
          this.playerForm.reset();
          window.alert('Joueur ' + player.username + ' a été ajouté');
        }, error => {
          console.log('erreur de mise à jour :');
          console.log(error);
        }
      );
    }
  }

  ngOnInit() {
  }

}
