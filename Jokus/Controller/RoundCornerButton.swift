//
//  RoundCornerButton.swift
//  Jokus
//
//  Created by Apple on 11/03/2018.
//  Copyright © 2018 Jokus. All rights reserved.
//

import UIKit

@IBDesignable
class RoundCornerButton: UIButton {

    @IBInspectable var cornerRadius: CGFloat = 0 {
        didSet {
            self.layer.cornerRadius = cornerRadius
        }
    }
    
    @IBInspectable var borderWidth: CGFloat = 0 {
        didSet {
            self.layer.borderWidth = borderWidth
        }
    }
    
    
    @IBInspectable var borderColor: UIColor = UIColor.clear {
        didSet {
            self.layer.borderColor = borderColor.cgColor
        }
    }
    
}
