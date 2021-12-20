package com.example.elraedaelkobra

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.elraedaelkobra.databinding.ActivityQuranBinding
import com.example.islamicapp.ui.Constants
import com.example.islamicapp.ui.home.fragments.adapters.SuraNamesAdapter

class MainActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityMainBinding
    private lateinit var binding: ActivityQuranBinding

    //lateinit var viewModel: MainViewModel
    lateinit var adapter: SuraNamesAdapter

    val chapterNames = listOf<String>(
        "الفاتحه",
        "البقرة",
        "آل عمران",
        "النساء",
        "المائدة",
        "الأنعام",
        "الأعراف",
        "الأنفال",
        "التوبة",
        "يونس",
        "هود",
        "يوسف",
        "الرعد",
        "إبراهيم",
        "الحجر",
        "النحل",
        "الإسراء",
        "الكهف",
        "مريم",
        "طه",
        "الأنبياء",
        "الحج",
        "المؤمنون",
        "النّور",
        "الفرقان",
        "الشعراء",
        "النّمل",
        "القصص",
        "العنكبوت",
        "الرّوم",
        "لقمان",
        "السجدة",
        "الأحزاب",
        "سبأ",
        "فاطر",
        "يس",
        "الصافات",
        "ص",
        "الزمر",
        "غافر",
        "فصّلت",
        "الشورى",
        "الزخرف",
        "الدّخان",
        "الجاثية",
        "الأحقاف",
        "محمد",
        "الفتح",
        "الحجرات",
        "ق",
        "الذاريات",
        "الطور",
        "النجم",
        "القمر",
        "الرحمن",
        "الواقعة",
        "الحديد",
        "المجادلة",
        "الحشر",
        "الممتحنة",
        "الصف",
        "الجمعة",
        "المنافقون",
        "التغابن",
        "الطلاق",
        "التحريم",
        "الملك",
        "القلم",
        "الحاقة",
        "المعارج",
        "نوح",
        "الجن",
        "المزّمّل",
        "المدّثر",
        "القيامة",
        "الإنسان",
        "المرسلات",
        "النبأ",
        "النازعات",
        "عبس",
        "التكوير",
        "الإنفطار",
        "المطفّفين",
        "الإنشقاق",
        "البروج",
        "الطارق",
        "الأعلى",
        "الغاشية",
        "الفجر",
        "البلد",
        "الشمس",
        "الليل",
        "الضحى",
        "الشرح",
        "التين",
        "العلق",
        "القدر",
        "البينة",
        "الزلزلة",
        "العاديات",
        "القارعة",
        "التكاثر",
        "العصر",
        "الهمزة",
        "الفيل",
        "قريش",
        "الماعون",
        "الكوثر",
        "الكافرون",
        "النصر",
        "المسد",
        "الإخلاص",
        "الفلق",
        "الناس"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // binding = ActivityMainBinding.inflate(layoutInflater)
        binding = ActivityQuranBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

//        val repository = Repository()
//        val viewModelFactory = MainViewModelFactory(repository)
//        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        initRecyclerView()


//        binding.getTafseer.setOnClickListener{
//
//            val suraNumber = binding.suraNumber.text.toString().toInt()
//            val ayahNumber = binding.ayahNumber.text.toString().toInt()
//            viewModel.getPost2(suraNumber, ayahNumber)
//            viewModel.myResponse2.observe(this, Observer { response ->
//
//                if(response.isSuccessful){
//
//                    binding.displayTafseer.text = response.body()?.text.toString()
//                }else{
//
//                    binding.displayTafseer.text = response.code().toString()
//                }
//            })
//       }
//
//        binding.getRecitation.setOnClickListener{
//
//            val ayahNumber = binding.ayahNumber.text.toString()
//            viewModel.getRecitation(ayah_key = ayahNumber)
//            viewModel.myResponse3.observe(this, Observer { response ->
//
//                if(response.isSuccessful){
//
//                    val audioUrl = response.body()?.audio_files?.get(0)?.url.toString();
//                    binding.displayTafseer.text = audioUrl
//
//
//
//                    // initializing media player
////                    val mediaPlayer = MediaPlayer().apply{
////                        setAudioAttributes(
////                            AudioAttributes.Builder()
////                                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
////                                .setUsage(AudioAttributes.USAGE_MEDIA)
////                                .build()
////                        )
////                        setDataSource("https://api.quran.com/api/v4/recitations/1/by_ayah/${ayahNumber}")
////                        prepare()
////                        start()
////                    }
//
//
//
//                }else{
//
//                    binding.displayTafseer.text = response.code().toString()
//                }
//            })
//        }
    }

    private fun initRecyclerView() {

        adapter = SuraNamesAdapter(chapterNames)
        adapter.onItemCLickListener = object : SuraNamesAdapter.OnItemClickListener {

            override fun onItemClick(position: Int, item: String) {

                //Toast.makeText(requireActivity(), "Sura number : $position", Toast.LENGTH_LONG).show()
                showSuraDetails(item, position)
            }
        }
        binding.quranFragmentRecyclerView.adapter = adapter
    }

    private fun showSuraDetails(name: String, pos: Int) {
        val intent = Intent(this, SuraDetailsActivity::class.java)
        intent.putExtra(Constants.EXTRA_SURA_NAME, name)
        intent.putExtra(Constants.EXTRA_SURA_POSITION, pos)
        startActivity(intent)
    }

}





