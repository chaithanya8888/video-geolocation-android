
Pod::Spec.new do |s|
  s.name         = "RNVideoGeolocationAndroid"
  s.version      = "1.0.0"
  s.summary      = "RNVideoGeolocationAndroid"
  s.description  = <<-DESC
                    RNVideoGeolocationAndroid is used to fetch the video location in android
                   DESC
  s.homepage     = "https://github.com/chaithanya8888/video-geolocation-android.git"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "vchaitanya@travogram.com" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/chaithanya8888/video-geolocation-android.git", :tag => "master" }
  s.source_files  = "RNVideoGeolocationAndroid/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

  