package homework.chegg.com.chegghomework.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import homework.chegg.com.chegghomework.R
import homework.chegg.com.chegghomework.data.network.entity.responses.ErrorResponse
import homework.chegg.com.chegghomework.databinding.ActivityMainBinding
import homework.chegg.com.chegghomework.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buildUI()
        subscribeUI()
    }

    private fun buildUI() = with(binding) {
        setContentView(root)
        setSupportActionBar(toolbar.root)
        articlesRv.adapter = ArticlesAdapter()
    }

    private fun subscribeUI() {
        viewModel.articlesLiveData.observe(this) {
            hideLoading()
            (binding.articlesRv.adapter as ArticlesAdapter).submitList(it)
        }
        viewModel.errorsLiveData.observe(this) {
            if (it.isNotEmpty()) showErrorDialog(it.first())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_refresh -> {
                onRefreshData()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun onRefreshData() {
        showLoading()
        viewModel.getArticles()
    }

    private fun showLoading() = with(binding) {
        if (progressBar.isGone) {
            window?.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            )
            progressBar.isVisible = true
        }
    }

    private fun hideLoading() = with(binding) {
        if (progressBar.isVisible) {
            window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            progressBar.isVisible = false
        }
    }

    private fun showErrorDialog(errorResponse: ErrorResponse) {
        AlertDialog.Builder(this).setTitle(errorResponse.title).setMessage(errorResponse.message)
            .setNegativeButton(errorResponse.button, null).create().show()
    }
}