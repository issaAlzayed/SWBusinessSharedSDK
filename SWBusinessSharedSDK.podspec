#
#  Be sure to run `pod spec lint SWBusinessSharedSDK.podspec' to ensure this is a
#  valid spec and to remove all comments including this before submitting the spec.
#
#  To learn more about Podspec attributes see https://guides.cocoapods.org/syntax/podspec.html
#  To see working Podspecs in the CocoaPods repo see https://github.com/CocoaPods/Specs/
#

Pod::Spec.new do |spec|
  spec.name         = "SWBusinessSharedSDK"
  spec.version      = "0.0.1"
  spec.summary      = "SWBusinessSharedSDK is shared SDK for all in-house projects."

  spec.description  = <<-DESC
                        SWBusinessSharedSDK is SDK that being used for now just in purpose of POC while in the future it is our business core, shared for all projects..
                   DESC

  spec.homepage     = 'https://github.com/NeoMENATech/SWBusinessSharedSDK'
  spec.license      = { :type => 'MIT', :file => 'LICENSE' }
  spec.author       = { "Issa Alzayed" => "issa.alzayed@neo.ae" }
  
  spec.source = { :git => "https://issaAlzayed:9817c516df70c683c75227ebd92faaa8f61384cf@github.com/NeoMENATech/SWBusinessSharedSDK.git", :tag => spec.version.to_s, }
                  
  spec.ios.deployment_target = '15.0'
  spec.vendored_frameworks   = 'shared/build/bin/iosX64/releaseFramework/SWBusinessSharedSDK.framework'
  spec.requires_arc = true
end