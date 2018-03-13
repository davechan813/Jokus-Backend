//
//  LoginViewController.swift
//  Jokus
//
//  Created by Apple on 11/03/2018.
//  Copyright © 2018 Jokus. All rights reserved.
//

import UIKit

class LoginViewController: UIViewController {
    @IBOutlet weak var UserImageView: UIImageView!
    @IBOutlet weak var UserNameUITextField: UITextField!
    @IBOutlet weak var PasswordUITextField: UITextField!
    @IBOutlet weak var LoginContainerView: UIView!
    @IBOutlet weak var SignInButton: RoundCornerButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        UserImageView.layer.cornerRadius = UserImageView.frame.size.width / 2;
        UserImageView.clipsToBounds = true
        
        UserNameUITextField.layer.borderWidth = 0.1
        UserNameUITextField.layer.borderColor = UIColor.lightGray.cgColor
        
        PasswordUITextField.layer.borderWidth = 0.1
        PasswordUITextField.layer.borderColor = UIColor.lightGray.cgColor
        
        
        LoginContainerView.layer.masksToBounds = false
        LoginContainerView.layer.shadowRadius = 2.0
        LoginContainerView.layer.shadowColor = UIColor.lightGray.cgColor
        LoginContainerView.layer.shadowOpacity = 0.3
        
//        SignInButton.layer.shadowRadius = 0.5
//        SignInButton.layer.shadowColor = UIColor.lightGray.cgColor
//        SignInButton.layer.shadowOpacity = 0.3
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
