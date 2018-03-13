//
//  ViewController.swift
//  Jokus
//
//  Created by Apple on 11/03/2018.
//  Copyright © 2018 Jokus. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var logo_Image: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        logo_Image.layer.cornerRadius = 50
        logo_Image.clipsToBounds = true
        logo_Image.layer.borderWidth = 1
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

