import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class AuthService {
  constructor() {}

  public login(username: string, pwd: string) {
    if (username == "admin" && pwd == "pwd") {
      localStorage.setItem("state", "connected");
      return true;
    } else {
      localStorage.setItem("state", "disconnected");
      return false;
    }
  }

  public logout() {
    localStorage.removeItem("state");
  }
}
