let TEmploye = [['abderrahmen','Myriam',2,new Date(1959,09,30)],
                ['Abbess'     ,'Jilani',1,new Date(1965,10,11)],
                ['SALEH'      ,'AHMED' ,1,new Date(1969,11,16)],
                ['BACHA'      ,'Jihen' ,2,new Date(1978,09,07)],
                ['SOLTANI'    ,'ASMA'  ,2,new Date(1991,00,26)],
                ['FARAH'      ,'Mourad',1,new Date(1973,05,04)]
               ]


function CreerMatricule() {
	var nom = document.f1.txtnom.value.trim().toUpperCase();
	var prenom = document.f1.txtprenom.value.trim().toLowerCase();
	var sexe = parseInt(document.f1.optsexe.value);
	var dateNaissance = new Date(document.f1.txtDDN.value);
  
	var asciiCodeNom = nom.charCodeAt(0);
	var asciiCodePrenom = prenom.charCodeAt(0);
	var moisNaissance = ('0' + (dateNaissance.getMonth() + 1)).slice(-2);
	var anneeNaissance = dateNaissance.getFullYear().toString().slice(-4);
	var codeSexe = (sexe === 2) ? '2' : '1';
  
	var matricule = `${asciiCodeNom}/${asciiCodePrenom}/${codeSexe}/${moisNaissance}/${anneeNaissance}`;
  
	document.f1.txtmat.value = matricule;
  }
  
  function ValiderCreation(txt) {
	var nom = document.f1.txtnom.value.trim();
	var prenom = document.f1.txtprenom.value.trim();
	var dateNaissance = document.f1.txtDDN.value;
  
	if (nom === '' || prenom === '' || dateNaissance === '') {
	  document.f1.btncreer.disabled = true;
	  document.f1.txtmat.value = '';
	  return;
	}
  
	document.f1.btncreer.disabled = false;
  }
  

  var RechercheSexe = (sexe) => {
	let resultat = "";
	let listeEmployes = [];
	TEmploye.forEach((employe) => {
	  if (employe[2] === sexe) {
		listeEmployes.push(`${employe[0]} ${employe[1]}`);
	  }
	});
	resultat = `La liste des employés de sexe ${sexe === 1 ? 'Masculin' : 'Féminin'} est : ${listeEmployes.join('/')}`;
	document.f1.txtresultat.value = resultat;
  }
  
  
