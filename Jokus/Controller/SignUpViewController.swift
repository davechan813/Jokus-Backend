//
//  SignUpViewController.swift
//  Jokus
//
//  Created by Apple on 12/03/2018.
//  Copyright © 2018 Jokus. All rights reserved.
//

import UIKit

class SignUpViewController: UIViewController {

    @IBOutlet weak var UserImageView: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        UserImageView.layer.cornerRadius = UserImageView.frame.size.width / 2;
        UserImageView.clipsToBounds = true
        
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
