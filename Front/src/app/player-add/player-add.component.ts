import { Component, OnInit } from '@angular/core';
import {ApiConnectionService} from '../service/api-connection.service';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-player-add',
  templateUrl: './player-add.component.html',
  styleUrls: ['./player-add.component.css']
})
export class PlayerAddComponent implements OnInit {

  playerForm;

  constructor(
    private formBuilder: FormBuilder,
    private connectionService: ApiConnectionService
    )
    {
      this.playerForm = this.formBuilder.group({
        username: ''
      });
  }
    onSubmit(player) {
      // window.alert('Le joueur a été ajouté ' + player.username);
      this.connectionService.addPlayer(player).subscribe(savePlayer => console.log(savePlayer));
      this.playerForm.reset();
    }


  ngOnInit() {
  }

}
