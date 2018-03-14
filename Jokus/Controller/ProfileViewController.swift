//
//  ProfileViewController.swift
//  Jokus
//
//  Created by Apple on 13/03/2018.
//  Copyright © 2018 Jokus. All rights reserved.
//

import UIKit

class ProfileViewController: UIViewController {

    @IBOutlet weak var UserImageView: UIImageView!
    
    @IBOutlet weak var MsgContainer: UIView!
    @IBOutlet weak var FeedContainer: UIView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        UserImageView.layer.cornerRadius = UserImageView.frame.size.width / 2;
        UserImageView.clipsToBounds = true
        
        MsgContainer.layer.cornerRadius = 25;
        MsgContainer.layer.borderWidth = 0.5
        MsgContainer.layer.borderColor = UIColor.clear.cgColor
        
        FeedContainer.layer.cornerRadius = 25;
        FeedContainer.layer.borderWidth = 0.5
        FeedContainer.layer.borderColor = UIColor.clear.cgColor
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
